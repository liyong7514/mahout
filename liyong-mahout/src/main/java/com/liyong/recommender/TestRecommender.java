package com.liyong.recommender;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.User;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.*;
import java.net.URL;
import java.util.List;

/**
 * User: liyong
 * Date: 13-11-13
 * Time: 上午10:27
 */
public class TestRecommender {

    public static void main(String[]args) throws Exception{


        File file = new File("/home/liyong/workspace/mahout/liyong-mahout/target/classes/data.csv");
        DataModel model = new FileDataModel(file);

        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

        UserNeighborhood neighborhood = new NearestNUserNeighborhood(2,similarity,model);

        UserBasedRecommender recommender = new GenericUserBasedRecommender(model,neighborhood,similarity);

        List<User> users = recommender.mostSimilarUsers("1", 2);

        System.out.println("最相似的用户:");
        for(User u:users){
            System.out.println(u);
        }

        System.out.println("给用户推荐:");
        List<RecommendedItem> recommend = recommender.recommend("1",3);
        for(RecommendedItem item:recommend){
            System.out.println(item);
        }



    }
}
