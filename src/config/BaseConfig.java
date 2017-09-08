package config;   

import model.User;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
  
public class BaseConfig extends JFinalConfig {  
      
    @Override  
    public void configConstant(Constants me) {  
        // TODO Auto-generated method stub  
        PropKit.use("demo_config.txt");  
        me.setDevMode(PropKit.getBoolean("devMode", false));  
    }  
    
    @Override  
    public void configHandler(Handlers me) {  
        // TODO Auto-generated method stub  
          
    }  
    
    @Override  
    public void configInterceptor(Interceptors me) {  
        // TODO Auto-generated method stub  
          
    }  
    
    @Override  
    public void configPlugin(Plugins me) {  
        C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());  
        me.add(c3p0Plugin);  
          
        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);  
        me.add(arp);  
          
        arp.addMapping("user", User.class);  
    }
    
	@Override
	public void configRoute(Routes arg0) {
		// TODO Auto-generated method stub
	}  
}  