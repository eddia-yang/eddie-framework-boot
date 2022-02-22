package com.project.gennerator;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MysqlGenerator {

	private DataSourceConfig dsc;
	private String parent;

	public static void main(String[] args) {
		MysqlGenerator mysqlGenerator = new MysqlGenerator("localhost", 3306, "xc_user", "root",
				"root");
		mysqlGenerator.setParent("com.project");
		mysqlGenerator.run();
	}

	public MysqlGenerator(DataSourceConfig dsc) {
		this.dsc = dsc;
	}

	public MysqlGenerator(String url, String username, String password) {
		this.dsc = new DataSourceConfig();
		this.dsc.setUrl(url);
		this.dsc.setDriverName("com.mysql.jdbc.Driver");
		this.dsc.setUsername(username);
		this.dsc.setPassword(password);
	}

	public MysqlGenerator(String ip, int port, String dbname, String username, String password) {
		this.dsc = new DataSourceConfig();
		this.dsc.setUrl("jdbc:mysql://" + ip + ":" + port + "/" + dbname + "?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8");
		this.dsc.setDriverName("com.mysql.cj.jdbc.Driver");
		this.dsc.setUsername(username);
		this.dsc.setPassword(password);
	}

	private String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder help = new StringBuilder();
		help.append("请输入" + tip + "：");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotBlank(ipt)) {
				return ipt;
			}
		}

		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}

	public void run() {
		boolean run = true;

		while(run) {
			System.out.println("exit退出");
			String modulename = this.scanner("模块名称");
			if ("exit".equals(modulename)) {
				run = false;
				return;
			}

			String tablename = this.scanner("表名");
			if ("exit".equals(tablename)) {
				run = false;
				return;
			}

			this.run(modulename, tablename);
		}

		System.err.println("已经退出");
	}

	public void run(String modulename, String tablename) {
		AutoGenerator mpg = new AutoGenerator();
		mpg.setDataSource(this.dsc);
		GlobalConfig gc = new GlobalConfig();
		final String projectPath = System.getProperty("user.dir");
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setAuthor("auto");
		gc.setOpen(false);
		gc.setSwagger2(true);
		gc.setIdType(IdType.ASSIGN_ID);
		gc.setDateType(DateType.TIME_PACK);
		mpg.setGlobalConfig(gc);
		final PackageConfig pc = new PackageConfig();
		pc.setModuleName(modulename);
		if (this.parent == null) {
			this.parent = "com.nsc.boot.platform.modules";
		}

		pc.setParent(this.parent);
		mpg.setPackageInfo(pc);
		InjectionConfig cfg = new InjectionConfig() {
			public void initMap() {
			}
		};
		List<FileOutConfig> focList = new ArrayList();
		focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
			public String outputFile(TableInfo tableInfo) {
				return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + ".xml";
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);
		mpg.setTemplate((new TemplateConfig()).setXml((String)null));
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setSuperEntityClass("com.mybatis.commom.base.BaseEntity");
		strategy.setSuperServiceClass("com.mybatis.commom.base.IBaseService");
		strategy.setSuperServiceImplClass("com.mybatis.commom.base.impl.BaseServiceImpl");
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
		strategy.setSuperControllerClass("com.commom.controller.BaseController");
		strategy.setInclude(new String[]{tablename});
		strategy.setSuperEntityColumns(new String[]{"id", "creater_id", "create_date", "modifier_id", "modify_date"});
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setLogicDeleteFieldName("is_deleted");
		strategy.setEntityBooleanColumnRemoveIsPrefix(true);
		mpg.setStrategy(strategy);
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

}
