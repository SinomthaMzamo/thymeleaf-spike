package org.example;

import java.time.LocalDate;

import org.example.model.ToyRobot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

/**
 * Hello Thymeleaf
 */
@SpringBootApplication
public class TemplateApp
{
    private TemplateEngine templateEngine;

    public static void main( String[] args )
    {
//        final TemplateApp app = new TemplateApp();
//        app.start();
        SpringApplication.run(TemplateApp.class, args);
    }

    private void start(){
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver( configureTemplateResolver() );

        final TemplateSpec templateSpec = createTemplateSpec();

        System.out.println( templateEngine.process(
                templateSpec,
                initVariableData( new ToyRobot( "Fred", LocalDate.of( 2022, 2, 2 ), 38 ))));
        System.out.println( templateEngine.process(
                templateSpec,
                initVariableData( new ToyRobot( "Pluto", LocalDate.of( 1873, 4, 1 ), 13 ))));
        System.out.println( templateEngine.process(
                templateSpec,
                initVariableData( new ToyRobot( "Ming", LocalDate.now(), 21 ))));
    }

    //FIXME
    private ITemplateResolver configureTemplateResolver(){
        final FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setPrefix( "src/main/resources/templates/" );
        resolver.setSuffix( ".html" );
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false);
        return resolver;
    }

    //FIXME
    private TemplateSpec createTemplateSpec(){
        return new TemplateSpec("robot-template", TemplateMode.HTML);
    }

    private Context initVariableData( ToyRobot aRobot ){
        final Context ctx = new Context();
        ctx.setVariable( "bot", aRobot );
        return ctx;
    }
}