package com.test.storm_study;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import java.util.Map;

/**
 * Created by DaiYan on 2017/11/18.
 */
public class UpperBolt extends BaseBasicBolt {
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        String originWord=tuple.getString(0);
        String upperWord=originWord.toUpperCase();
        System.out.println("upperWord==>"+upperWord);
        basicOutputCollector.emit(new Values(upperWord));
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("upperWord"));
    }
}
