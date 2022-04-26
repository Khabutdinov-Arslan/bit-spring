package ru.fileshare.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import java.io.File;

public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        final var context = new AnnotationConfigWebApplicationContext();
        context.scan("ru.fileshare");
        context.refresh();

        final var servlet = new DispatcherServlet(context);
        final var registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        final var maxFileSize = 100000;
        final var maxRequestSize = 200000;
        final var fileSizeThreshold = 50000;
        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));
        MultipartConfigElement multipartConfigElement = new  MultipartConfigElement(uploadDirectory.getAbsolutePath(), maxFileSize, maxRequestSize, fileSizeThreshold);

        registration.setMultipartConfig(multipartConfigElement);
    }
}
