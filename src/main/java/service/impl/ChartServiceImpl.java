package service.impl;

import mapper.ChartMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.PieChart;
import service.ChartService;
import utils.SqlSessionFactoryUtils;

import java.util.List;
//
public class ChartServiceImpl implements ChartService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<PieChart> selectForTypeTopFive() {
        SqlSession sqlSession = factory.openSession();
        ChartMapper mapper = sqlSession.getMapper(ChartMapper.class);
        List<PieChart> pieCharts = mapper.selectForTypeTopFive();
        sqlSession.close();
        return pieCharts;
    }

    @Override
    public PieChart selectForUnitPriceTopFive(int begin, int end) {
        SqlSession sqlSession = factory.openSession();
        ChartMapper mapper = sqlSession.getMapper(ChartMapper.class);
        PieChart pieChart = mapper.selectForUnitPriceTopFive(begin, end);
        sqlSession.close();
        return pieChart;
    }

    @Override
    public List<PieChart> selectForAddressTopThree() {
        SqlSession sqlSession = factory.openSession();
        ChartMapper mapper = sqlSession.getMapper(ChartMapper.class);
        List<PieChart> pieCharts = mapper.selectForAddressTopThree();
        sqlSession.close();
        return pieCharts;
    }

    @Override
    public List<PieChart> selectForCommunityTopFive() {
        SqlSession sqlSession = factory.openSession();
        ChartMapper mapper = sqlSession.getMapper(ChartMapper.class);
        List<PieChart> pieCharts = mapper.selectForCommunityTopFive();
        sqlSession.close();
        return pieCharts;
    }

    @Override
    public List<PieChart> selectForShelfDate() {
        SqlSession sqlSession = factory.openSession();
        ChartMapper mapper = sqlSession.getMapper(ChartMapper.class);
        List<PieChart> pieCharts = mapper.selectForShelfDate();
        sqlSession.close();
        return pieCharts;
    }

    @Override
    public List<PieChart> selectForUnitPrice() {
        SqlSession sqlSession = factory.openSession();
        ChartMapper mapper = sqlSession.getMapper(ChartMapper.class);
        List<PieChart> pieCharts = mapper.selectForUnitPrice();
        sqlSession.close();
        return pieCharts;
    }

    @Override
    public List<PieChart> selectForTypeSize() {
        SqlSession sqlSession = factory.openSession();
        ChartMapper mapper = sqlSession.getMapper(ChartMapper.class);
        List<PieChart> pieCharts = mapper.selectForTypeSize();
        sqlSession.close();
        return pieCharts;
    }
}
