package utils.swagger2;

//import com.winway.btc.common.vo.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger API 配置文件
 */
@Configuration
@EnableSwagger2
@PropertySource("classpath:config/swagger.properties")
public class SwaggerConfig {
	
	/**
	 * 是否启用文档
	 */
	@Value("${swagger.enable}")
	private boolean enableSwagger;

	@Bean
    public Docket api() {
		List<ResponseMessage> responseMessageList = new ArrayList<>();
//	    responseMessageList.add(new ResponseMessageBuilder().code(JsonResult.STATUS_SUCCESS).message("请求成功").build());
//	    responseMessageList.add(new ResponseMessageBuilder().code(JsonResult.STATUS_FAIL).message("请求失败").build());
//	    responseMessageList.add(new ResponseMessageBuilder().code(JsonResult.STATUS_NO_LOGIN).message("未登录").build());
	    
        return new Docket(DocumentationType.SWAGGER_2)
//        		.globalResponseMessage(RequestMethod.GET, responseMessageList)
//                .globalResponseMessage(RequestMethod.POST, responseMessageList)
//                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
//                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .apiInfo(apiInfo())
                .enable(enableSwagger)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.winway.btc"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("接口文档")
                .termsOfServiceUrl("https://")
                .version("1.0")
                .build();
    }
    
}
