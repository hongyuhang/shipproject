package com.cbdz.sib.model.convertor;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Method;

public class SConvertorB1 extends BaseConvertor {
    public JSONObject convert(JSONObject x_json) {
        String[] p_fields = new String[]{
                "longitude",
                "latitude",
                "positionAccuracy",
                "utcDay",
                "utcHour",
                "utcMinute",
                "averageWindSpeed",
                "windGust",
                "windDirection",
                "windGustDirection",
                "airTemperature",
                "relativeHumidity",
                "dewPoint",
                "airPressure",
                "airPressureTendency",
                "horizontalVisibility",
                "waterLevel",
                "waterLevelTrend",
                "surfaceCurrentSpeed",
                "surfaceCurrentDirection",
                "currentSpeed2",
                "currentDirection2",
                "currentMeasuringLevel2",
                "currentSpeed3",
                "currentDirection3",
                "currentMeasuringLevel3",
                "significantWaveHeight",
                "wavePeriod",
                "waveDirection",
                "swellHeight",
                "swellPeriod",
                "swellDirection",
                "seaState",
                "waterTemperature",
                "precipitation",
                "salinity",
                "ice"
        };
        Method[] p_ms = new Method[]{
                m_calcLongitude,
                m_calcLatitude,
                m_calcPositionAccuracy,
                m_calcUtcDay,
                m_calcUtcHour,
                m_calcUtcMinute,
                m_calcWindSpeed,
                m_calcWindSpeed,
                m_calcDirection,
                m_calcDirection,
                m_calcAirTemperature,
                m_calcRelativeHumidity,
                m_calcDewPoint,
                m_calcAirPressure,
                m_calcAirPressureTendency,
                m_calcHorizontalVisibility,
                m_calcWaterLevel,
                m_calcWaterLevelTrend,
                m_calcSpeed,
                m_calcDirection,
                m_calcSpeed,
                m_calcDirection,
                m_calcMeasuringLevel,
                m_calcSpeed,
                m_calcDirection,
                m_calcMeasuringLevel,
                m_calcWaveHeight,
                m_calcPeriod,
                m_calcDirection,
                m_calcWaveHeight,
                m_calcPeriod,
                m_calcDirection,
                m_calcSeaState,
                m_calcWaterTemperature,
                m_calcPrecipitation,
                m_calcSalinity,
                m_calcIce
        };
        return super.convertByArg(x_json, p_fields, p_ms);
    }
}
