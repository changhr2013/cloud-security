package com.changhr.cloud.securtiy.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author changhr2013
 * @date 2019/11/24
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class FileInfo {
    private String path;
}
