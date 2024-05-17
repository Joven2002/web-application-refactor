package com.system.demo.appl.model.station;

    public class Station {
        public int getStationId() {
            return stationId;
        }

        public void setStationId(int stationId) {
            this.stationId = stationId;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public Station(int stationId, String stationName) {
            this.stationId = stationId;
            this.stationName = stationName;
        }

        private int stationId;

        private String stationName;


        public Station(){

        }
    }
