
The goal of this project is to monitor 24hr trading volumes of various crypto currencies and alert a user whenever there is a sudden jump in the trading volume. 

The consuming-coinmarketcap-api project stores the cryptocurrencies price and volume info as obtained from the coinmarketcap API into a PostGres RDBMS. Currently coinmarketcap provides price updates at a regular interval of 5 mins. 

The CryptoStatistics project loads this price and volume data from the DB. It computes a number of statistics on price/volume data for past 6 months, 1 month, 2 weeks, 1 week and 3 days. It compares the latest price/volume data with the statistics it computed and if there is a jump of (say) 2x in volume compared to the statistics, it notifies a user via email this information. 

