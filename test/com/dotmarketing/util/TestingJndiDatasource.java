package com.dotmarketing.util;

import javax.naming.spi.InitialContextFactoryBuilder;
import javax.naming.spi.NamingManager;

/**
 * This class will set up the data source for testing. The main purpose here
 * is to be able to run the integration tests without the web app container
 * i.e. Tomcat. Database related configuration for testing should be
 * implemented following the same pattern.
 *
 * Running this in your junit tests will set dotCMS up for you:
 * <pre>
 * {@code
 * &#64;BeforeAll
 * public static void setUpBeforeAll() throws Exception {
 *     TestingJndiDatasource.init();
 *     ConfigTestHelper._setupFakeTestingContext();
 * }
 * }
 * </pre>
 *
 * Note: Code snippet above should be useful on testing APIs that don't require ES.
 * If ES is needed, you will need to include also the config for ES.
 */
public class TestingJndiDatasource {

    private static InitialContextFactoryBuilder builder;

    static {
        builder = new TestInitialContextFactory();
    }

    public static void init() throws Exception {
        NamingManager.setInitialContextFactoryBuilder(builder);
    }
}
