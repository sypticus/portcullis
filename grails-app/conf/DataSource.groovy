import org.codehaus.groovy.grails.orm.hibernate.cfg.GrailsAnnotationConfiguration

 dataSource {
    configClass = GrailsAnnotationConfiguration.class
    pooled = false
    driverClassName = "com.mysql.jdbc.Driver"  // uncomment for mysql
    //driverClassName = "com.hsql.jdbc.Driver"
    username = "portcullis"   //uncomment for mysql
  //  username = "sa"
    password = "m0t3b0ss"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
}

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of ‘create’, ‘create-drop’,'update’
         //   url = "jdbc:hsqldb:mem:devDB" //jdbc:hsqldb:file:devDB;shutdown=true
            url = "jdbc:mysql://127.0.0.1:3306/portcullis"   // uncomment  for mysql
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:hsqldb:mem:testDb"
        }
    }
    production {
        dataSource {
             dbCreate = "update" // one of ‘create’, ‘create-drop’,'update’
         //   url = "jdbc:hsqldb:mem:devDB" //jdbc:hsqldb:file:devDB;shutdown=true
            url = "jdbc:mysql://127.0.0.1:3306/portcullis"   // uncomment  for mysql
        }
    }

}
