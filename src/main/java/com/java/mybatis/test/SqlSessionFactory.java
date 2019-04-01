package com.java.mybatis.test;

/**
 * description：用来获取SqlSession类型的对象
 * author：丁鹏
 * date：11:27
 */
public class SqlSessionFactory {
    private static final  SqlSession sqlSession = new SqlSessionImpl();
    private static final SqlSession sqlSessionB = new SqlSessionImplB();
    private static final SqlSession sqlSessionC = new SqlSessionImplB();

    /**
     * 静态工厂方法：返回的是sqlsession对象
     * @return
     */
    public static  SqlSession getInstanceByFactory(){
        if("windows7".equals("windows7")){
            return sqlSession;
        }
        if("window8".equals("window8")){
            return sqlSessionC;
        }
        //shiro
        return sqlSessionB;
    }

}
