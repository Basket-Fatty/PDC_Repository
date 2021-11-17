package com.mycompany.pdcproject.database.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mycompany.pdcproject.database.bean.ColumnInfo;
import com.mycompany.pdcproject.database.bean.JavaFieldGetSet;
import com.mycompany.pdcproject.database.bean.TableInfo;
import com.mycompany.pdcproject.database.core.DBManager;
import com.mycompany.pdcproject.database.core.DerbyTypeConvertor;
import com.mycompany.pdcproject.database.core.TableContext;
import com.mycompany.pdcproject.database.core.TypeConvertor;

/**
 * 封装了Java文件(源代码)常用的操作
 *
 * @author Arthur
 *
 */
public class JavaFileUtils {

    /**
     * 根据字段信息生成java属性信息 如:varchar username-->private String
     * userName;以及相应的set和get方法源码
     *
     * @param colum 字段信息
     * @param convertor 类型转化器
     * @return java属性和set/get方法
     */
    public static JavaFieldGetSet createFieldSetGet(ColumnInfo column, TypeConvertor convertor) {
        JavaFieldGetSet jfgs = new JavaFieldGetSet();

        String javaFieldType = convertor.datebaseType2JavaType(column.getDataType());

        jfgs.setFieldInfo("\tprivate " + javaFieldType + " " + column.getName() + ";\n");

        StringBuilder getSrc = new StringBuilder();
        getSrc.append("\tpublic " + javaFieldType + " get" + StringUtils.firstChar2UpperCase(column.getName()) + "(){\n");
        getSrc.append("\t\treturn " + column.getName() + ";\n");
        getSrc.append("\t}\n");
        jfgs.setGetInfo(getSrc.toString());

        StringBuilder setSrc = new StringBuilder();
        setSrc.append("\tpublic void set" + StringUtils.firstChar2UpperCase(column.getName()) + "(");
        setSrc.append(javaFieldType + " " + column.getName() + "){\n");
        setSrc.append("\t\tthis." + column.getName() + "=" + column.getName() + ";\n");
        setSrc.append("\t}\n");
        jfgs.setSetInfo(setSrc.toString());

        return jfgs;
    }

    /**
     * 根据表信息生成java类的源代码
     *
     * @param tableInfo 表信息
     * @param convertor 数据类型转化器
     * @return java类的源代码
     */
    public static String createJavaSrc(TableInfo tableInfo, TypeConvertor convertor) {

        Map<String, ColumnInfo> columns = tableInfo.getColumns();
        List<JavaFieldGetSet> javaFields = new ArrayList<>();

        for (ColumnInfo c : columns.values()) {
            javaFields.add(createFieldSetGet(c, convertor));
        }

        StringBuilder src = new StringBuilder();
        src.append("package " + DBManager.getConf().getPoPackage() + ";\n\n");
        src.append("import java.sql.*;\n");
        src.append("import java.util.*;\n\n");
        src.append("public class " + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + " {\n\n");

        for (JavaFieldGetSet f : javaFields) {
            src.append(f.getFieldInfo());
        }
        src.append("\n\n");

        for (JavaFieldGetSet f : javaFields) {
            src.append(f.getGetInfo());
        }
        for (JavaFieldGetSet f : javaFields) {
            src.append(f.getSetInfo());
        }

        src.append("}\n");
        return src.toString();
    }

    public static void createJavaPOFile(TableInfo tableInfo, TypeConvertor convertor) {
        String src = createJavaSrc(tableInfo, convertor);

        String srcPath = DBManager.getConf().getSrcPath() + "\\";
        //正则表达式
        String packagePath = DBManager.getConf().getPoPackage().replaceAll("\\.", "\\\\");
        
        File f = new File(srcPath + packagePath);
        if (!f.exists()) {
            f.mkdirs();
        }

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile() + "/" + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + ".java"));
            bw.write(src);
            System.out.println("建立表" + tableInfo.getTname()
                    + "对应的java类:" + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + ".java");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bw) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //测试

    public static void main(String[] args) {
//  ColumnInfo ci = new ColumnInfo("username", "varchar", 0);
//  JavaFieldGetSet f = createFieldSetGet(ci, new MySqlTypeConvertor());
//  System.out.println(f);

        Map<String, TableInfo> map = TableContext.tables;
        for (TableInfo tableInfo : map.values()) {
            createJavaPOFile(tableInfo, new DerbyTypeConvertor());
        }
    }
}
