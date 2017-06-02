package com.draper.domain;

import java.io.Serializable;

/**
 * 将所有 PO 类实现 Serializable 接口
 * 以便将 PO 类序列化到硬盘中
 * 或是通过流的方式发送，为缓存集群带来便利
 */
public class BaseDomain implements Serializable{
}