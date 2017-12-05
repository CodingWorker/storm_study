package com.test.storm_study;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import org.omg.PortableInterceptor.ORBInitInfo;

import java.util.Map;
import java.util.Random;

/**
 * Created by DaiYan on 2017/11/18.
 */
public class SpoutDemo extends BaseRichSpout {
    private SpoutOutputCollector collector;
    private static final String[] phones={"iphone","xiaomi","meizu","huawei","sanxing"};
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector=collector;
    }

    public void nextTuple() {
        int index= new Random().nextInt(phones.length);
        String originWord=phones[index];
        System.out.println("originWord==>"+originWord);
        this.collector.emit(new Values(originWord));
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("originWord"));
    }
}
