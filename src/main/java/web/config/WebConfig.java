package web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Locale;

@Configuration//данный класс используется контейнером Spring IoC, как конфигурационный класс для создания бинов
@EnableWebMvc//включения модуля Spring MVC в приложение
@ComponentScan("web")//сканируем (ищем) бины (@Component) в пакете "web"
public class WebConfig implements WebMvcConfigurer {//имплеминтируемся от интерфейса, чтобы изменить настройки по умолчанию

    // определяет местоположение статических ресурсов
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {//
        registry.addResourceHandler("/WEB-INF/pages/**").addResourceLocations("/pages/");
    }

    @Bean//перед методом, информирует Spring о том, что возвращаемый данным методом объект
    // должен быть зарегистрирован, как бин
    // а этот бин инициализирует View нашего проекта
    public InternalResourceViewResolver setupViewResolver() {//
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        //resolver.resolveViewName("")
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {//
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();//в конфигурации этого перехватчика определяется
        // параметр "параметр" для смены региональных настроек веб приложения
        interceptor.setParamName("locale");
        registry.addInterceptor(interceptor);
    }

    @Bean
    //загрузка сообщений из определенных файлов предназначенных для интернационализации
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("WEB-INF/locales/cars");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setFallbackToSystemLocale(false);//если специальный компонент не обнаружен - вернуться по уполчанию
        return messageSource;
    }

    @Bean
        //хранение и извлечение региоанальных настроек из браузера
    CookieLocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        cookieLocaleResolver.setCookieMaxAge(3600);
        cookieLocaleResolver.setCookieName("locale");
        return cookieLocaleResolver;
    }
}