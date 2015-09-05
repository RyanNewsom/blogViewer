package mobileclass.kylesblogviewer;

/**
 * Created by Kyle on 9/5/2015.
 */
public class BlogPost {
    private int id;
    private String title;
    private String subTitile;
    private String date;
    private String imageUrl;
    private String postBody;

    public BlogPost(int id, String title, String subTitile, String date, String imageUrl, String postBody) {
        this.setId(id);
        this.setTitle(title);
        this.setSubTitile(subTitile);
        this.setDate(date);
        this.setImageUrl(imageUrl);
        this.setPostBody(postBody);
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitile() {
        return subTitile;
    }

    public void setSubTitile(String subTitile) {
        this.subTitile = subTitile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
