package mobi.cangol.mobile.utils;

import android.test.AndroidTestCase;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;


/**
 * Created by weixuewu on 16/6/12.
 */
public class Object2FileUtilsTest extends AndroidTestCase {

    public void testWriteJSONObject2File() throws Exception {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","jack");
        jsonObject.put("id","1001");
        Object2FileUtils.writeJSONObject2File(jsonObject,StorageUtils.getExternalCacheDir(getContext()).getAbsolutePath()+"/testObj.json");
    }

    public void testWriteJSONArray2File() throws Exception {
        JSONArray jsonArray=new JSONArray();
        jsonArray.put("jack");
        jsonArray.put("Jim");
        Object2FileUtils.writeJSONArray2File(jsonArray,StorageUtils.getExternalCacheDir(getContext()).getAbsolutePath()+"/testArray.json");
    }

    public void testReadFile2JSONArray() throws Exception {
        Object2FileUtils.readFile2JSONArray(new File(StorageUtils.getExternalCacheDir(getContext()).getAbsolutePath()+"/testArray.json"));
    }

    public void testReadFile2JSONObject() throws Exception {
        Object2FileUtils.readFile2JSONObject(new File(StorageUtils.getExternalCacheDir(getContext()).getAbsolutePath()+"/testObj.json"));
    }

    public void testWriteJSONArray() throws Exception {
        JSONArray jsonArray=new JSONArray();
        jsonArray.put("jack");
        jsonArray.put("Jim");
        //Object2FileUtils.writeJSONArray(jsonArray,new FileOutputStream(StorageUtils.getExternalCacheDir(getContext()).getAbsolutePath()+"/testArray.json"));

        //Object2FileUtils.readJSONArray(new FileInputStream(StorageUtils.getExternalCacheDir(getContext()).getAbsolutePath()+"/testArray.json"));
    }

    public void testWriteJSONObject() throws Exception {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","jack");
        jsonObject.put("id","1001");
        //Object2FileUtils.writeJSONObject(jsonObject,new FileOutputStream(StorageUtils.getExternalCacheDir(getContext()).getAbsolutePath()+"/testObj.json"));

        //Object2FileUtils.readJSONObject(new FileInputStream(StorageUtils.getExternalCacheDir(getContext()).getAbsolutePath()+"/testObj.json"));
    }

    public void testReadJSONObject() throws Exception {

    }

    public void testReadJSONArray() throws Exception {
    }

    public void testWriteObject() throws Exception {
        User user=new User("1","jack");
        //Object2FileUtils.writeObject(user,StorageUtils.getExternalCacheDir(getContext()).getAbsolutePath()+"/user.ser");
    }

    public void testReadObject() throws Exception {
        //Object2FileUtils.readJSONObject(new FileInputStream(StorageUtils.getExternalCacheDir(getContext()).getAbsolutePath()+"/user.ser"));
    }

    public void testWriteObject1() throws Exception {
        User user=new User("1","jack");
        //Object2FileUtils.writeObject(user,new FileOutputStream(StorageUtils.getExternalCacheDir(getContext()).getAbsolutePath()+"/user.ser"));
    }

    public void testReadObject1() throws Exception {
        Object2FileUtils.readObject(new File(StorageUtils.getExternalCacheDir(getContext()).getAbsolutePath()+"/user.ser"));
    }
    class User implements Serializable{
        String id;
        String name;
        User(){}
        User(String id,String name){
            this.id=id;
            this.name=name;
        }
    }
}