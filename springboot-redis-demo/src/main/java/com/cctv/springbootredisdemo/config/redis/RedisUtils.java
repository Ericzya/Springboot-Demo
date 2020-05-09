package com.cctv.springbootredisdemo.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisUtils
 * @Description: RedisUtils
 * @Author: Eric.Zhang
 * @Date: 2020/4/26 19:20
 * @version: 1.0
 */
@Service
public class RedisUtils {
    private RedisTemplate redisTemplate;

    @Autowired
    public RedisUtils(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //- - - - - - - - - - - - - - - - - - - - -  公共方法 - - - - - - - - - - - - - - - - - - - -

    /**
     * 给一个指定的 key 值附加过期时间
     *
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key, long time) {
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key
     * @return
     */
    public long getTime(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 移除指定key 的过期时间
     *
     * @param key
     * @return
     */
    public boolean persist(String key) {
        return redisTemplate.boundValueOps(key).persist();
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (hasKey(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 将值放入缓存
     *
     * @param key   键
     * @param value 值
     * @return true成功 false 失败
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 将值放入缓存并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) -1为无期限
     * @return true成功 false 失败
     */
    public void set(String key, Object value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }


    //- - - - - - - - - - - - - - - - - - - - -  String类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * 根据key获取值
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 批量添加 key (重复的键会覆盖)
     *
     * @param keyAndValue
     */
    public void batchSet(Map<String, String> keyAndValue) {
        redisTemplate.opsForValue().multiSet(keyAndValue);
    }

    /**
     * 批量添加 key-value 只有在键不存在时,才添加
     * map 中只要有一个key存在,则全部不添加
     *
     * @param keyAndValue
     */
    public void batchSetIfAbsent(Map<String, String> keyAndValue) {
        redisTemplate.opsForValue().multiSetIfAbsent(keyAndValue);
    }

    /**
     * 对一个 key-value 的值进行加减操作,
     * 如果该 key 不存在 将创建一个key 并赋值该 number
     * 如果 key 存在,但 value 不是长整型 ,将报错
     *
     * @param key
     * @param number
     */
    public Long increment(String key, long number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    /**
     * 对一个 key-value 的值进行加减操作,
     * 如果该 key 不存在 将创建一个key 并赋值该 number
     * 如果 key 存在,但 value 不是 纯数字 ,将报错
     *
     * @param key
     * @param number
     */
    public Double increment(String key, double number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    //- - - - - - - - - - - - - - - - - - - - -  set类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * 将数据放入set
     *
     * @param key 键
     * @return
     */
    public void sAdd(String key, String value) {
        redisTemplate.opsForSet().add(key, value);
    }

    public void sAdd(String key, Set set) {
        if (set != null) {
            set.forEach(obj -> {
                redisTemplate.opsForSet().add(key, obj);
            });
        }
    }

    /**
     * 获取set
     *
     * @param key 键
     * @return
     */
    public Set<Object> sMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 随机获取set中指定个数的元素
     *
     * @param key   键
     * @param count 值
     * @return
     */
    public void sRandomMembers(String key, long count) {
        redisTemplate.opsForSet().randomMembers(key, count);
    }

    /**
     * 随机获取set中的元素
     *
     * @param key 键
     * @return
     */
    public Object sRandomMember(String key) {
        return redisTemplate.opsForSet().randomMember(key);
    }

    /**
     * 弹出set中的元素
     *
     * @param key 键
     * @return
     */
    public Object sPop(String key) {
        return redisTemplate.opsForSet().pop(key);
    }

    /**
     * 获取set长度
     *
     * @param key 键
     * @return
     */
    public long sSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean sHasKey(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * 转移变量的元素值到目的变量。
     *
     * @param key     键
     * @param value   元素对象
     * @param destKey 元素对象
     * @return
     */
    public boolean sMove(String key, String value, String destKey) {
        return redisTemplate.opsForSet().move(key, value, destKey);
    }

    /**
     * 批量移除set缓存中元素
     *
     * @param key    键
     * @param values 值
     * @return
     */
    public void sRemove(String key, Object... values) {
        redisTemplate.opsForSet().remove(key, values);
    }

    /**
     * 通过给定的key求2个set变量的差值
     *
     * @param key     键
     * @param destKey 键
     * @return
     */
    public Set<Set> sDifference(String key, String destKey) {
        return redisTemplate.opsForSet().difference(key, destKey);
    }

    public Set sIntersectAndStore(String set1, String set2) {
        return redisTemplate.opsForSet().intersect(set1, set2);
    }


    //- - - - - - - - - - - - - - - - - - - - -  hash类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * 哈希 添加
     *
     * @param key
     * @param map
     */
    public void hmSet(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    public void put(String key, String map, Object value) {
        redisTemplate.opsForHash().put(key, map, value);
    }

    /**
     * 获取 key 下的 所有  hashkey 和 value
     *
     * @param key 键
     * @return
     */
    public Map<Object, Object> hmGet(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 获取指定key的值string
     *
     * @param key1 键
     * @param key2 键
     * @return
     */
    public String getMapString(String key1, String key2) {
        return redisTemplate.opsForHash().get(key1, key2).toString();
    }

    /**
     * 验证指定 key 下 有没有指定的 hashkey
     *
     * @param key
     * @param hashKey
     * @return
     */
    public boolean hashKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    /**
     * 获取指定的值Int
     *
     * @param key1 键
     * @param key2 键
     * @return
     */
    public Integer getMapInt(String key1, String key2) {
        return (Integer) redisTemplate.opsForHash().get(key1, key2);
    }

    /**
     * 删除指定 hash 的 HashKey
     *
     * @param key
     * @param hashKeys
     * @return 删除成功的 数量
     */
    public Long delete(String key, String... hashKeys) {
        return redisTemplate.opsForHash().delete(key, hashKeys);
    }

    /**
     * 给指定 hash 的 hashkey 做增减操作
     *
     * @param key
     * @param hashKey
     * @param number
     * @return
     */
    public Long increment(String key, String hashKey, long number) {
        return redisTemplate.opsForHash().increment(key, hashKey, number);
    }

    /**
     * 给指定 hash 的 hashkey 做增减操作
     *
     * @param key
     * @param hashKey
     * @param number
     * @return
     */
    public Double increment(String key, String hashKey, Double number) {
        return redisTemplate.opsForHash().increment(key, hashKey, number);
    }

    /**
     * 获取 key 下的 所有 hashkey 字段
     *
     * @param key
     * @return
     */
    public Set<Object> hashKeys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    /**
     * 获取指定 hash 下面的 键值对 数量
     *
     * @param key
     * @return
     */
    public Long hashSize(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    //- - - - - - - - - - - - - - - - - - - - -  list类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * 在变量左边添加元素值
     *
     * @param key
     * @param value
     * @return
     */
    public void leftPush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 在变量右边添加元素值
     *
     * @param key
     * @param value
     * @return
     */
    public void rightPush(String key, Object value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 获取集合指定位置的值。
     *
     * @param key
     * @param index
     * @return
     */
    public Object index(String key, long index) {
        return redisTemplate.opsForList().index("list", index);
    }

    /**
     * 获取指定区间的值。
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> range(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 把最后一个参数值放到指定集合的第一个出现传值参数的前面，
     * 如果中间参数值存在的话。
     *
     * @param key
     * @param pivot
     * @param value
     * @return
     */
    public void leftPush(String key, Object pivot, Object value) {
        redisTemplate.opsForList().leftPush(key, pivot, value);
    }

    /**
     * 向左边批量添加参数元素。
     *
     * @param key
     * @param values
     * @return
     */
    public void leftPushAll(String key, String... values) {
        redisTemplate.opsForList().leftPushAll(key, values);
    }

    /**
     * 向左边批量添加参数元素。
     *
     * @param key
     * @param values
     * @return
     */
    public void leftPushAll(String key, Integer... values) {
        redisTemplate.opsForList().leftPushAll(key, values);
    }

    /**
     * 向左边批量添加参数元素。
     *
     * @param key
     * @param list
     * @return
     */
    public void leftPushAll(String key, List<Integer> list) {
        if (list != null) {
            list.forEach(v -> {
                redisTemplate.opsForList().rightPush(key, v);
            });
        }
    }

    /**
     * 向集合最右边添加元素。
     *
     * @param key
     * @param value
     * @return
     */
    public void leftPushAll(String key, String value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 向左边批量添加参数元素。
     *
     * @param key
     * @param values
     * @return
     */
    public void rightPushAll(String key, String... values) {
        redisTemplate.opsForList().rightPushAll(key, values);
    }

    /**
     * 向已存在的集合中添加元素。
     *
     * @param key
     * @param value
     * @return
     */
    public void rightPushIfPresent(String key, Object value) {
        redisTemplate.opsForList().rightPushIfPresent(key, value);
    }

    /**
     * 获取list长度
     *
     * @param key
     * @return
     */
    public long length(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 移除集合中的左边第一个元素。
     *
     * @param key
     * @return
     */
    public void leftPop(String key) {
        redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 移除集合中左边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
     *
     * @param key
     * @return
     */
    public void leftPop(String key, long timeout, TimeUnit unit) {
        redisTemplate.opsForList().leftPop(key, timeout, unit);
    }

    /**
     * 移除集合中右边的元素。
     *
     * @param key
     * @return
     */
    public void rightPop(String key) {
        redisTemplate.opsForList().rightPop(key);
    }

    /**
     * 移除集合中右边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
     *
     * @param key
     * @return
     */
    public void rightPop(String key, long timeout, TimeUnit unit) {
        redisTemplate.opsForList().rightPop(key, timeout, unit);
    }

    //- - - - - - - - - - - - - - - - - - - - -  Sorted Set类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * 添加值
     *
     * @param key
     * @param value
     * @param score
     */
    public void zAdd(String key, Object value, Double score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 去除值
     *
     * @param key
     * @param values
     */
    public void zRemove(String key, Object... values) {
        redisTemplate.opsForZSet().remove(key, values);
    }

    /**
     * 给值增加权重
     *
     * @param key
     * @param value
     * @param addScore
     * @return
     */
    public Double zIncrementScore(String key, Object value, Double addScore) {
        return redisTemplate.opsForZSet().incrementScore(key, value, addScore);
    }

    /**
     * 返回有序集中指定成员的排名，其中有序集成员按分数值递增(从小到大)顺序排列
     *
     * @param key
     * @param value
     * @return
     */
    public Long zRank(String key,Object value){
        return redisTemplate.opsForZSet().rank(key,value);
    }

    /**
     * 返回有序集中指定成员的排名，其中有序集成员按分数值递减(从大到小)顺序排列
     *
     * @param key
     * @param value
     * @return
     */
    public Long zReverseRank(String key,Object value){
        return redisTemplate.opsForZSet().reverseRank(key,value);
    }

    /**
     * 获取有序集合的成员数
     *
     * @param key
     * @return
     */
    public Long zSize(String key){
        return redisTemplate.opsForZSet().size(key);
    }
}