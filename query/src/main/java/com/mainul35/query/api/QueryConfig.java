package com.mainul35.query.api;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//@EnableJpaRepositories(basePackages ={"com.mainul35.common.*"})
//@EntityScan(basePackages = {
//        "com.mainul35.common.*",
//        "org.axonframework.eventhandling.tokenstore.jpa"
//})
public class QueryConfig {

    @Bean
    public XStream xStream () {
        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.allowTypesByWildcard(new String[] {
                "com.mainul35.common.event.*"
        });
        return xstream;
    }
}
