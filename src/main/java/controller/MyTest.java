package controller;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import its.fei.test.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import po.HeHe;
import po.HeList;
import service.CountryService;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.springframework.core.GenericCollectionTypeResolver.getCollectionType;

/**
 * Created by life on 2015/12/30.
 */
@RestController
@RequestMapping("/myTest")
public class MyTest {
    public static ObjectMapper objectMapper;
    @Autowired
    private CountryService countryService;

    private  String page_list = "index";

    @RequestMapping("/get")
    @ResponseBody
    public List<HeHe> save(String text) throws IOException {
        System.out.println(text.toString());
        JSONObject jsonParam = JSON.parseObject(text);
       // buildReport();
        System.out.println("================开始查询===============");
        ModelAndView result = new ModelAndView(page_list);
        List<Country> countryList = countryService.selectByCountry(new Country(), 1, 10);
        result.addObject("pageInfo", new PageInfo<Country>(countryList));
        result.addObject("queryParam", new Country());
        result.addObject("page", 1);
        result.addObject("rows", 10);
        return null;
    }

    /*public static void buildReport( ){
        System.out.println("=========================开始创建报表======================");
        JasperReportBuilder report= DynamicReports.report();//创建空报表
        //样式
        StyleBuilder boldStl=DynamicReports.stl.style().bold();
        StyleBuilder boldCenteredStl=DynamicReports.stl.style(boldStl).setHorizontalAlignment(HorizontalAlignment.CENTER);
        StyleBuilder titleStl=DynamicReports.stl.style(boldCenteredStl).setFontSize(16);
        StyleBuilder columnTitleStl=DynamicReports.stl.style(boldCenteredStl).setBorder(DynamicReports.stl.pen1Point())
                .setBackgroundColor(Color.LIGHT_GRAY);
        report.columns(Columns.column("ID", "id", DataTypes.integerType()).
                        setHorizontalAlignment(HorizontalAlignment.CENTER),//列
                Columns.column("手机号段", "code", DataTypes.stringType()).
                        setHorizontalAlignment(HorizontalAlignment.CENTER),//列
                Columns.column("运营商", "service", DataTypes.stringType()).
                        setHorizontalAlignment(HorizontalAlignment.CENTER),//列
                Columns.column("省份", "province", DataTypes.stringType()).
                        setHorizontalAlignment(HorizontalAlignment.CENTER),//列
                Columns.column("城市", "city", DataTypes.stringType()).
                        setHorizontalAlignment(HorizontalAlignment.CENTER),//列
                Columns.column("品牌", "type", DataTypes.listType()).
                        setHorizontalAlignment(HorizontalAlignment.CENTER)//列
        )
                .setColumnTitleStyle(columnTitleStl)
                .setHighlightDetailEvenRows(true)
                .title(getPieCharts())//标题
        .pageFooter(Components.pageXofY().setStyle(boldCenteredStl))//页角
                .setDataSource(setData())
        ;
        System.out.println("=========================开始创建报表======================");
        try {
            //显示报表
            //report.show();
            System.out.println("=========================开始创建报表======================");
            //生成PDF文件
            report.toXlsx(new FileOutputStream("C:/Users/hzc/Desktop/test.xlsx"));
            System.out.println("=========================开始创建报表======================");
        } catch (DRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static DRDataSource setData(){
        List<String> listdats = new ArrayList<String>();
        listdats.add("小米");
        listdats.add("iphone");
        listdats.add("HUWEI");
        DRDataSource dataSource = new DRDataSource("id","code", "service", "province", "city","type");
        dataSource.add(01,"0791", "移动", "江西","南昌",listdats);
        dataSource.add(02, "0791", "电信", "北京", "北京市", listdats);
        dataSource.add(03, "0791", "联通", "江西", "南昌", listdats);
        return dataSource;
    }

    private static PieChartBuilder getPieCharts() {
        TextColumnBuilder<String> resNameCol = col.column("运营商", "name", type.stringType());
        TextColumnBuilder<Integer> minutesCol = col.column("用户数", "value", type.integerType());
        PieChartBuilder pieChart = cht.pieChart()
                .setTitle("运营商用户统计统计")
                .setTitleFont(DynamicReports.stl.font("", true, false, 18))
                .setSubtitle("各运营商使用人数如下:" )
                .setKey(resNameCol)
                .series(cht.serie(minutesCol))
                .setDataSource(setChartData());
        return pieChart;
    }
    public static DRDataSource setChartData(){
        DRDataSource dataSource = new DRDataSource("name", "value");
        dataSource.add( "移动", 1);
        dataSource.add("电信", 1 );
        dataSource.add( "联通", 1);
        return dataSource;
    }*/

}
