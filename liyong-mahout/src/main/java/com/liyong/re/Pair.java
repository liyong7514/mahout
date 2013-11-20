package com.liyong.re;

/**
 * User: liyong
 * Date: 13-11-20
 * Time: 下午6:30
 */
public class Pair<V,K> {

    V itemId;

    K rating;

    public Pair(V v,K k){
        this.itemId = v;
        this.rating = k;
    }
    public K getRating() {
        return rating;
    }

    public void setRating(K rating) {
        this.rating = rating;
    }

    public V getItemId() {
        return itemId;
    }

    public void setItemId(V itemId) {
        this.itemId = itemId;
    }
}
