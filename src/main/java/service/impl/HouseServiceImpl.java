package service.impl;

import mapper.HouseMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.House;
import service.HouseService;
import utils.SqlSessionFactoryUtils;

import java.util.List;

public class HouseServiceImpl implements HouseService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<House> selectAll() {
        SqlSession sqlSession = factory.openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        List<House> houses = mapper.selectAll();
        sqlSession.close();
        return houses;
    }

    @Override
    public List<House> selectByPage(int begin, int size) {
        SqlSession sqlSession = factory.openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        List<House> houses = mapper.selectByPage(begin, size);
        sqlSession.close();
        return houses;
    }

    @Override
    public House selectById(int id) {
        SqlSession sqlSession = factory.openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        House house = mapper.selectById(id);
        sqlSession.close();
        return house;
    }

    @Override
    public int selectTotal() {
        SqlSession sqlSession = factory.openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        int total = mapper.selectTotal();
        sqlSession.close();
        return total;
    }

    @Override
    public void deleteById(int id) {
        SqlSession sqlSession = factory.openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void add(House house) {
        SqlSession sqlSession = factory.openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        mapper.add(house);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(House house) {
        SqlSession sqlSession = factory.openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        mapper.update(house);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<House> selectByCondition(House house) {
        SqlSession sqlSession = factory.openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        List<House> houses = mapper.selectByCondition(house);
        sqlSession.close();
        return houses;
    }

    @Override
    public int selectUnitPrice() {
        SqlSession sqlSession = factory.openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        int unitPrice = mapper.selectUnitPrice();
        sqlSession.close();
        return unitPrice;
    }

    @Override
    public int selectSize() {
        SqlSession sqlSession = factory.openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        int size = mapper.selectSize();
        sqlSession.close();
        return size;
    }

    @Override
    public int selectTotalPrice() {
        SqlSession sqlSession = factory.openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        int totalPrice = mapper.selectTotalPrice();
        sqlSession.close();
        return totalPrice;
    }
}
