package org.openweathermap.api.example;


import org.openweathermap.api.DataWeatherClient;
import org.openweathermap.api.UrlConnectionDataWeatherClient;
import org.openweathermap.api.model.currentweather.CurrentWeather;
import org.openweathermap.api.query.*;
import org.openweathermap.api.query.currentweather.CurrentWeatherOneLocationQuery;

public class CurrentWeatherOneLocationExample {
    private static final String API_KEY = "590661e9a75d81f118714bd102422eae";

    public static void main(String[] args) {
        DataWeatherClient client = new UrlConnectionDataWeatherClient(API_KEY);
        CurrentWeatherOneLocationQuery currentWeatherOneLocationQuery = QueryBuilderPicker.pick()
                .currentWeather()                   // get current weather
                .oneLocation()                      // for one location
                .byCityName("Frydrychowice")              // for Frydrychowice city
                .countryCode("PL")                  // in Poland
                .type(Type.ACCURATE)                // with Accurate search
                .language(Language.POLISH)         // in Polish language
                .responseFormat(ResponseFormat.JSON)// with JSON response format
                .unitFormat(UnitFormat.METRIC)      // in metric units
                .build();
        CurrentWeather currentWeather = client.getCurrentWeather(currentWeatherOneLocationQuery);
        System.out.println(prettyPrint(currentWeather));
    }

    private static String prettyPrint(CurrentWeather currentWeather) {
        return String.format(
                "Current weather in %s(%s):\ntemperature: %.1f ℃\nhumidity: %.1f %%\npressure: %.1f hPa\n"+
                "maximum temperature: %.1f\nminimum temperature: %.1f\nwind speed: %.1f  m/s\n",

                currentWeather.getCityName(), currentWeather.getSystemParameters().getCountry(),
                currentWeather.getMainParameters().getTemperature(),
                currentWeather.getMainParameters().getHumidity(),
                currentWeather.getMainParameters().getPressure(),
                currentWeather.getMainParameters().getMaximumTemperature(),
                currentWeather.getMainParameters().getMinimumTemperature(),
                currentWeather.getWind().getSpeed()

        );
    }
}
