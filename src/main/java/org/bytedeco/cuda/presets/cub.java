package org.bytedeco.cuda.presets;

import org.bytedeco.javacpp.annotation.NoException;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(
        inherit = cudart.class, 
        names = {"windows-x86_64"}, 
        target = "org.bytedeco.cuda.cub", 
        global = "org.bytedeco.cuda.global.cub",
        value = {
            @Platform(
                include = {
                    "<cub/device/device_histogram.cuh>",
                    "<cub/device/device_scan.cuh>",
                }
            )
        }
)
@NoException
@SuppressWarnings("java:S101")
public class cub implements InfoMapper
{
    @Override
    public void map(InfoMap infoMap)
    {
        infoMap.put(new Info("CUB_NS_PREFIX", "CUB_RUNTIME_FUNCTION").cppTypes().annotations());
        
        // cub::DeviceHistogram::HistogramEven<SampleIteratorT,CounterT,LevelT,OffsetT>
        infoMap.put(new Info("cub::DeviceHistogram::HistogramEven<float*,int,float,int>").javaNames("HistogramEven"));
        
        // cub::DeviceHistogram::MultiHistogramRange<NUM_CHANNELS,NUM_ACTIVE_CHANNELS,SampleIteratorT,CounterT,LevelT,OffsetT>
        infoMap.put(new Info("cub::DeviceHistogram::MultiHistogramRange<1,1,float*,int,float,int>").javaNames("MultiHistogramRange1Channel"));
        infoMap.put(new Info("cub::DeviceHistogram::MultiHistogramRange<2,2,float*,int,float,int>").javaNames("MultiHistogramRange2Channel"));
        infoMap.put(new Info("cub::DeviceHistogram::MultiHistogramRange<2,2,float*,int,float,int>").javaNames("MultiHistogramRange3Channel"));
        infoMap.put(new Info("cub::DeviceHistogram::MultiHistogramRange<3,3,float*,int,float,int>").javaNames("MultiHistogramRange4Channel"));
        
        // cub::DeviceHistogram::HistogramRange<SampleIteratorT,CounterT,LevelT,OffsetT>
        infoMap.put(new Info("cub::DeviceHistogram::HistogramRange<float*,int,float,int>").javaNames("HistogramRange"));
        
        // cub::DeviceHistogram::MultiHistogramEven<NUM_CHANNELS,NUM_ACTIVE_CHANNELS,SampleIteratorT,CounterT,LevelT,OffsetT>
        infoMap.put(new Info("cub::DeviceHistogram::MultiHistogramEven<1,1,float*,int,float,int>").javaNames("MultiHistogramEven1Channel"));
        infoMap.put(new Info("cub::DeviceHistogram::MultiHistogramEven<2,2,float*,int,float,int>").javaNames("MultiHistogramEven2Channel"));
        infoMap.put(new Info("cub::DeviceHistogram::MultiHistogramEven<3,3,float*,int,float,int>").javaNames("MultiHistogramEven3Channel"));
        infoMap.put(new Info("cub::DeviceHistogram::MultiHistogramEven<4,4,float*,int,float,int>").javaNames("MultiHistogramEven4Channel"));
        
        infoMap.put(new Info("cub::DeviceScan::ExclusiveSum<int*,int*>").javaNames("ExclusiveSum"));
        infoMap.put(new Info("cub::DeviceScan::InclusiveSum<int*,int*>").javaNames("InclusiveSum"));
    }
}
