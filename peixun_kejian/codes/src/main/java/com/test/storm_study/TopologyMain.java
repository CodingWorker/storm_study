package com.test.storm_study;

import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;

/**
 * Created by DaiYan on 2017/11/18.
 */
public class TopologyMain {
    public static void main(String[] args) throws Exception{
        TopologyBuilder builder=new TopologyBuilder();

        builder.setSpout("randomWord",new SpoutDemo(),2).setNumTasks(2);
        builder.setBolt("upperWord",new UpperBolt(),2).shuffleGrouping("randomWord");
        builder.setBolt("suffixWord",new SuffixBolt(),2).shuffleGrouping("upperWord");

        Config conf=new Config();
        conf.setDebug(true);
        conf.setNumWorkers(4);
        conf.setNumAckers(0);

        StormTopology topology= builder.createTopology();
        StormSubmitter.submitTopology("stormdemo",conf,topology);
    }
}
