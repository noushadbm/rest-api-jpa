package com.rayshan.bdd;

import com.rayshan.ServiceApplication;
import com.rayshan.config.TestConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@SpringBootTest(classes = {TestConfig.class, ServiceApplication.class})
@ActiveProfiles("test")
public class BaseIntegrationTest {
}
