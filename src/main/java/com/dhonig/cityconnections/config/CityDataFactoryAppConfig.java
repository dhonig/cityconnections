import com.dhonig.cityconnections.factory.CityDataFactory;
import com.dhonig.cityconnections.model.CityData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CityDataFactoryAppConfig {

    @Bean(name = "cityData")
    public CityDataFactory cityDataFactory() {
        CityDataFactory factory = new CityDataFactory();
        return factory;
    }

    @Bean
    public CityData cityData() throws Exception {
        return cityDataFactory().getObject();
    }
}