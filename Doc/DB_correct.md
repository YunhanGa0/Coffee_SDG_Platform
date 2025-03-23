# 数据库修改

## farm

- created_at/update_at感觉不需要，可以被establish_year替代

## products

- created_at/update_at问题

## reserve applicaitons

- farm_id和farmer_id只留farm就可以？

## user

- created_at/update_at问题

## promotion

- startTime&endTime感觉不需要，createTime可以留





## 主要两个问题：

1. 创建时间大部分表都不需要，但文章类的可以在页面上显示
2. 在发布促销文章/报名培训/申请资金等操作的时候，由于farmer和farm是多对一，是不是应该以农场名义来记录？就是记录farmi而不是farmerid。或者直接farmer-farm一对一，就是农场主账户来操作，技术支持给整个农场，资金也给整个农场