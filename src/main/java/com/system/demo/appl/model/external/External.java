package com.system.demo.appl.model.external;

import com.system.demo.appl.model.station.Station;

public class External {
    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    private Long externalId;

    private Station station;
    public External(){

    }
}
