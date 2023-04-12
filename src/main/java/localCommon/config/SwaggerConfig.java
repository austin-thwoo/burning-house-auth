//package localCommon.config;
//
//import java.util.Arrays;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import io.swagger.v3.oas.models.servers.Server;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.spring.web.plugins.SpringDocSecurityConfiguration;
//import springfox.documentation.swagger.web.SecurityConfiguration;
//import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
//
//@Configuration
//@EnableOpenApi
//public class SwaggerConfig {
//
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .components(new Components().addSecuritySchemes("bearer-key",
//                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
//                .info(new Info().title("PoC").version("Austin")
//                        .description("PoC \n contextPath = 192.168.1.48:10024/api/poc \n \n " +
//                                "table \n \n" +
//                                "company - 거래처,제조사,공장 \n" +
//                                "document - 문서 \n" +
//                                "examination - 시험신청 \n" +
//                                "examinationHistory - 시험신청 기록 \n" +
//                                "pic - 담당자 \n" +
//                                "proReferenceFile - 참고자료 \n" +
//                                "requirement - 요구사항 \n" +
//                                "test - 시험정 \n" +
//                                "stdxxxx - 규격정보 \n" +
//                                "user - 회원"))
//                .addServersItem(new Server().url("http://localhost:8080/"));
//    }
//
//    @Bean
//    public Docket commonApi() {
//        return new Docket(DocumentationType.OAS_30)
//                .ignoredParameterTypes(AuthenticationPrincipal.class)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.ant("/api/poc/**"))
//                .build()
//                .securitySchemes(Arrays.asList(apiKey()))
//                .securityContexts(Arrays.asList(securityContext()))
//                .useDefaultResponseMessages(false)
//                .apiInfo(apiInfo());
//    }
//
//    @Bean
//    public Docket managerApi() {
//        return new Docket(DocumentationType.OAS_30)
//                .ignoredParameterTypes(AuthenticationPrincipal.class)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.ant("/api/brc/manage/**"))
//                .build()
//                .securitySchemes(Arrays.asList(apiKey()))
//                .securityContexts(Arrays.asList(securityContext()))
//                .useDefaultResponseMessages(false)
//                .apiInfo(apiInfo());
//    }
//
//    @Bean
//    public SecurityConfiguration securityConfiguration() {
//        return SecurityConfigurationBuilder.builder()
//                .clientId("
