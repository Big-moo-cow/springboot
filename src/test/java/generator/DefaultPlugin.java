package generator;

import org.mybatis.generator.api.PluginAdapter;

import java.util.List;

/**
 * @ClassName: DefaultPlugin
 * @Description: Mapper生成
 * @author: zhepan@outlook.com
 * @date: 2017/11/23 15:04
 */
public class DefaultPlugin extends PluginAdapter {

	@Override
    public boolean validate(List<String> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
