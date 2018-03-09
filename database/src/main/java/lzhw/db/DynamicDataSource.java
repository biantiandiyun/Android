package lzhw.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    public static final ThreadLocal<String> DATA_SOURCE_HOLDER = new ThreadLocal<String>();

    protected Object determineCurrentLookupKey() {
        String dsn =  DATA_SOURCE_HOLDER.get();
        if (dsn==null){
            dsn = DataSourceEnum.MASTER.getDefault();
            DATA_SOURCE_HOLDER.set(dsn);
        }
        return dsn;
    }

    public static void setDataSource(String dataSource) {
        DATA_SOURCE_HOLDER.set(dataSource);
    }
    public static void cleanDataSource() {
        DATA_SOURCE_HOLDER.remove();
    }
    public static String getDataSource() {
        String dataSource = DATA_SOURCE_HOLDER.get();
        // 如果没有指定数据源，使用默认数据源
        if (null == dataSource) {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getDefault());
        }
        return DATA_SOURCE_HOLDER.get();
    }


}
