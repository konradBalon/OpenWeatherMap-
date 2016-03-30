package org.openweathermap.api.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.model.Coordinate;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByGeographicCoordinates extends AbstractCurrentWeatherQuery {
    private final Coordinate coordinate;

    public ByGeographicCoordinates(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    protected String getRequestPart() {
        return String.format("lat=%s&lon=%s", coordinate.getLatitude(), coordinate.getLongitude());
    }
}