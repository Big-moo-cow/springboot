package cn.cza.springboot.commons.utils;import java.util.HashMap;import java.util.concurrent.ConcurrentHashMap;/** * @Author: 车子昂 * @Date: 2019-5-23 15:05 * @Description: */public class LocalCache {    private LocalCache() {    }   //防止外部实例化    // 使用volatile延迟初始化，防止编译器重排序    private static volatile LocalCache instance;    //单例   保证多线程安全    未初始化才进行创建    private static LocalCache getInstance() {        if (instance == null) {            synchronized (LocalCache.class) {                if (instance == null) {                    instance = new LocalCache();                }            }        }        return instance;    }    protected static final ConcurrentHashMap<String, Object> dataMap = new ConcurrentHashMap<String, Object>();    private static final Object lock = new Object();    private static Object get(String key) {        Object o = dataMap.get(key);        if (o == null) {            synchronized (lock) {                o = dataMap.get(key);            }        }        return o;    }    public static synchronized void set(String key, Object value) {        dataMap.put(key, value);    }    @SuppressWarnings("unchecked")    public static synchronized boolean isAccess(String ip, long maxTimeInterval, long maxTimes) {        HashMap<String, Object> map = (HashMap<String, Object>) dataMap.get(ip);        if(null == map){            map = new HashMap<String,Object>();            map.put("times",1);            map.put("timestamp",System.currentTimeMillis());            LocalCache.set(ip,map);            System.err.println(ip+":"+map);            return true;        }else{            int times = (int)dataMap.get("times");            long timestamp = (long)dataMap.get("timestamp");            if(System.currentTimeMillis()-timestamp >maxTimeInterval*1000){                map.put("times",1);                map.put("timestamp",System.currentTimeMillis());                LocalCache.set(ip,map);                System.err.println(ip+":"+map);                return true;            }else{                if(times<maxTimes){                    map.put("times",times+1);                    LocalCache.set(ip,map);                    System.err.println(ip+":"+map);                    return true;                }else{                    System.err.println("false");                    return false;                }            }        }    }}