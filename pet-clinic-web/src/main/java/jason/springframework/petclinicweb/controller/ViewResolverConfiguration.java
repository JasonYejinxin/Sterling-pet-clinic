package jason.springframework.petclinicweb.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

public class ViewResolverConfiguration {
    @Value("${spring.mvc.view.prefix}")
    private String prefix = "";

    @Value("${spring.mvc.view.suffix}")
    private String suffix = "";

    @Value("${spring.mvc.view.view-names}")
    private String viewNames = "";

    @Bean
    public InternalResourceViewResolver jspView(){

        InternalResourceViewResolver view = new InternalResourceViewResolver();
        view.setPrefix(prefix);
        view.setSuffix(suffix);
        view.setViewClass(JstlView.class);
        view.setViewNames(viewNames);
        return view;
    }
}