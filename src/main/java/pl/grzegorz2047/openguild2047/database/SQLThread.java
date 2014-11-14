/*
 * Copyright 2014 Aleksander.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.grzegorz2047.openguild2047.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import pl.grzegorz2047.openguild2047.GenConf;

/**
 *
 * @author Aleksander
 */
public class SQLThread implements Runnable {
    private Connection connection;
    private final SQLData data = GenConf.getSqlData();
    private final String query;
    
    public SQLThread(Connection connection, String query) {
        this.connection = connection;
        this.query = query;
    }
    
    @Override
    public void run() {
        try {
            if(connection.isClosed()) {
                connection = data.getDriver();
            }
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
        } catch (SQLException ex) {
            
        }
    }
    
    public SQLData getData() {
        return this.data;
    }
    
    public String getQuery() {
        return this.query;
    }
}