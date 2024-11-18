package com.devpro.yuubook.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;

@Configuration // Bean
@ControllerAdvice
@EnableWebMvc
@ComponentScan(basePackages = {"com.devpro.yuubook"})
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");// đường dẫn tới view
        bean.setSuffix(".jsp");// có đuôi file .jsp
        return bean;
    }

    /**
     * Mapping JS và CSS.
     * Notes:
     * 1. classpath <-> src/main/resources
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		client
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/META-INF/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/META-INF/js/");
        registry.addResourceHandler("/font/**").addResourceLocations("classpath:/META-INF/font/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/META-INF/images/");
        registry.addResourceHandler("/lib/**").addResourceLocations("classpath:/META-INF/lib/");
//		admin
        registry.addResourceHandler("/admin/**").addResourceLocations("classpath:/META-INF/admin/");
        registry.addResourceHandler("/files/**").addResourceLocations("file:upload\\");
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) { // 404
            // Otherwise setup and send the user to a default error-view.
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", req.getRequestURL());
            mav.setViewName("errors/404");
            return mav;
        } else {
            // Otherwise setup and send the user to a default error-view.
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", req.getRequestURL());
            mav.setViewName("errors/404");
            return mav;
        }
    }
}
