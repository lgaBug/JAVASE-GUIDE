# Http+PostMan 



## Http

> 超文本传输协议

### 三次握手

### 四次挥手

### 与HTTPS区别



## PostMan

### 接口请求四大要素

- **Method**
- **URL**
- Parameters
- Header 

### 接口返回三大要素

- Status Code
- Header
- Body

## 天气

## 百度IP

## 腾讯课堂

## post测试

http://www.testingedu.com.cn:8000/Home/user/login.html

资料修改 

## 环境遍历

## 断言

## 测试管理/测试集与数据驱动

## Cookie测试



## 自动化测试demo

记录短信接口的 test case

| title           | 输入值                                | 输出值                                 | 期望值                                            | isPass   |
| --------------- | ------------------------------------- | -------------------------------------- | ------------------------------------------------- | -------- |
| 正常情况下      | 95839331 NofP5VEN 15979900603 3333    | 返回的{"errcode":0,"errmsg":"SUCCESS"} | 返回的{"errcode":0,"errmsg":"SUCCESS"}            | **true** |
| 当账号错误      | 9583933 NofP5VEN 15979900603 3333     |                                        | 返回的 errcode:100....                            | true     |
| 当密码错误错误  | 95839331 NofP5VE 15979900603 3333     |                                        | 返回的 errcode:100...                             | true     |
| 当手机号错误    | 95839331 NofP5VEN 1597990060 3333     |                                        | "errcode": 100, "errmsg": "包含不合法的手机号"    | true     |
| 当验证码超过6位 | 95839331 NofP5VEN 15979900603 1234567 |                                        | "errcode": 100, "errmsg": "请提交4-6位数字验证码" | true     |

