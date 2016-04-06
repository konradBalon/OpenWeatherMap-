package org.openweathermap.api.query.currentweather;

import org.openweathermap.api.query.QueryBuilder;
import org.openweathermap.api.query.ResponseFormat;

public abstract class CurrentWeatherOneLocationQueryBuilder<T extends CurrentWeatherOneLocationQueryBuilder<T, E>, E extends CurrentWeatherOneLocationQuery> extends QueryBuilder<T, E> {
    protected abstract E getQuery();

    public T responseFormat(ResponseFormat responseFormat) {
        getQuery().setResponseFormat(responseFormat);
        return self();
    }
}