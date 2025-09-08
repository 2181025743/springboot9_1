import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class TestGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create(
                        "jdbc:mysql://localhost:3306/spring_demo?serverTimezone=UTC",
                        "root",
                        "aA1472580@")
                .globalConfig(builder -> {
                    builder.author("yx") // 设置作者
                            .enableSwagger() // 开启 Swagger 支持
                            .outputDir(System.getProperty("user.dir") + "/src/main/java"); // 输出路径
                })
                .packageConfig(builder -> {
                    builder.parent("com.yx.generator") // 设置包名
                            .moduleName("")              // 模块名（可为空）
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    System.getProperty("user.dir") + "/src/main/resources/mapper")); // Mapper XML 路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("employee") // 要生成的表名
                            .addTablePrefix("i_").entityBuilder().enableLombok(); // 去除前缀"i_"，生成类名Emp
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker模板引擎

                .execute();
    }
}