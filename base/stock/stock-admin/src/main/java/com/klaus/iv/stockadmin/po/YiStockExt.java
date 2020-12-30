package com.klaus.iv.stockadmin.po;

import com.klaus.iv.commonjpa.po.BasePo;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(indexes = {
        @Index(name = "index_code", columnList = "code", unique = true)
})
public class YiStockExt extends BasePo {
    @Column(nullable = false, columnDefinition = "varchar(8) default '' comment 'stock code'")
    private String code; //股票代码
    @Column(nullable = true, columnDefinition = "varchar(128) default '' comment '节能环保,次新股,预盈预增,融资融券,创业板综,尾气治理'")
    private String Block; // ""
    @Column(nullable = true, columnDefinition = "varchar(20) default '' comment 'ceo 名称'")
    private String Chairman; // "臧志成"
    private String CodeType; // "A股"
    private String CompRofile; // "    凯龙高科技股份有限公司成立于2001年,是集研发、生产、销售和售后服务为一体的国家高新技术企业,国家企业技术中心,中国合格评定国家认可委员会(CNAS)认可的实验中心,国家博士后科研工作站。凯龙高科除总部外,另有凯龙技术研究院、凯龙蓝烽新private String 材料科技有限公司、凯龙宝顿动力科技有限公司,占地总面积230余亩,员工1200余名。凯龙高科遵循“生产一代、研发一代、储备一代”科研方针,开发生产了满足国六标准的柴油机后处理系统、车/船用柴油机选择性催化还原SCR系统、主/被动再生颗粒捕集系统(DPF)、CNG/private String LNG/LPG后处理器、汽油机三元催化器、隧道/工业窑炉废气处理装置、汽车尾气加热系统、发动机智能温控冷却系统(ATS)、客车底盘集中润滑系统等高新技术产品。凯龙技术研究院是博士后科研工作站、国家企业技术中心、江苏省重点企业研发机构、江苏省工程技术研究中心private String 、江苏省企业技术中心,研发方向涵盖催化剂载体、催化涂层及催化剂活性组分研究、喷射控制器软硬件控制策略研究、尾气后处理产品结构及其焊接技术研究等领域,聚集各类专业背景的设计研发工程人员280余名,其中博士7名,硕士41名;拥有10个发动机综合测试台架,4个电力private String 瞬态试验台架,配有AVL电力测工机、排放仪、颗粒分析仪、激光粒度分析仪及振动、淋雨、盐雾、高低温等试验检测设备,具备对各种机型柴油机和后处理系统及核心部件进行性能测试与检测能力,拥有CVS(全流排放)private String 测试能力。凯龙技术研究院与华中科技大学、华东理工大学等科研院所长期合作,为公司产品技术创新提供强有力的支持。凯龙高科自主设计建造了载体催化剂涂覆流水线、蜂窝陶瓷载体生产流水线、尿素喷射泵装配流水线、喷射控制器(DCU)private String 流水线、泵罐一体式尿素配给系统装配流水线及催化器封装等多条流水线,具备尾气后处理系统完整产业链。凯龙高科坚持以高标准对每项质量要求进行严格把关,建立全面细致的质量控制体系,公司通过国际著名认证机构SGS的ISO/TS16949-2009质量管理体系认证和北京世标private String 认证中心ISO14001; //2004环境管理体系认证;通过PLM、ERP、CRM、MES等信息化管理平台的建设和各平台之间的数据业务整合,能够对产品设计、试验、制造、销售及维修准备等过程进行有效管控。凯龙高科秉承“诚信经营,合作共赢”的经营理念,依托主机厂和整车厂的服务网private String 络,在全国自主建立了八大区域售后服务中心、15个配件中心。目前公司已与潍柴、玉柴、锡柴、上柴、上汽依维柯红岩、南京依维柯、全柴、洛拖、雷沃、常柴等众多道路、非道路客户建立了良好的合作关系。凯龙高科依托国家科技创新基金、国家科技部政策引导类专项、国家private String 发改委重点产业振兴和技术改造专项、江苏省重大科技成果转化等多项国家、省市级项目支持,牵头或参与制定了18项行业标准,其中,10项SCR标准、5项DPF标准、2项催化剂载体标准和1项汽车行业标准;获得专利144项,其中,发明专利39项;柴油机尾气后处理系统入选国家科技private String 部重点新产品计划,SCR系统和DPF系统分别通过中国机械工业联合会科技成果鉴定;拥有中国工业先锋示范单位、中国机械工业管理示范企业、中国内燃机行业排头兵企业、中国机械工业联合会科学技术奖一等奖、上海市科学技术奖一等奖、江苏省著名商标等多项荣誉。同时,凯private String 龙高科在上级党组织和民建无锡市委的领导下,发挥党组织的领导核心作用和工会组织的桥梁纽带作用,投资250万元,建立了近1000平方米的党工共建基地,并挂牌惠山民建之家,走出了非公企业党建和企业发展互促共荣之路,先后荣获上级授予的“先进党组织”、“中华全国总工会private String 工人先锋号”等荣誉称号。“以技术创新、使天空更蓝”是凯龙高科的梦想;“奉献绿色环保,勇做行业先驱”是凯龙高科的追求。凯龙高科将继续秉承“爱国、民主、建设、团结、创新、奉献”的民建共同价值private String 理念,不断寻求产品和技术的创新,在实现公司新的跨越式发展的同时,为国家和社会的生态文明建设作出更大贡献!"
    private String CompanyCode; // "80746567"
    private String CompanyName; // "凯龙高科技股份有限公司"
    private String Currency; // "CNY"
    private String Email; // "kailong@kailongtec.com"
    private String Employees; // "1376"
    private String FoundDate; // "2001-12-12"
    private String GeneralManager; // "臧志成"
    private String Industry; // "机械设备-专用设备-环保设备"
    private String IsInnovation; // 0
    private String MainBusiness; // "内燃机尾气污染治理装备的研发、生产和销售"
    private String Managers; // "13"
    private String OfficeAddress; // "--"
    private String Phone; // "0510-68937717"
    private String PreviousName; // "--"
    private String Provice; // "江苏"
    private String RegisteredAddress; // "无锡惠山经济开发区钱桥配套区庙塘桥"
    private String RegisteredCapital; // "1.12亿"
    private String Representative; // "臧志成"
    private String Secretaries; // "曾睿"
    private String SecurityCode; // "300912.SZ"
    private String SecurityCodeA; // "300912"
    private String SecurityCodeB; // ""
    private String SecurityCodeH; // ""
    private String SecurityCodeType; // "1"
    private String SecurityNameA; // "凯龙高科"
    private String SecurityNameB; // ""
    private String SecurityNameH; // ""
    private String Website; // "www.kailongtec.com"

}
