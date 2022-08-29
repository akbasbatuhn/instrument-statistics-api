
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='[dbo].[stock]' and xtype='U')
CREATE TABLE [rv_is].[dbo].[stock](
	[isin_code] [varchar](255) PRIMARY KEY,
	[name] [varchar](255) NOT NULL,
	[exchange] [varchar](255) NULL,
	[last_update] [datetime2] NULL,
	[bid] [decimal](19, 6) NULL,
	[bid_volume] [int] NOT NULL,
	[offer] [decimal](19, 6) NULL,
	[offer_volume] [int] NOT NULL,
	[spread_percentage] [varchar](255) NULL,
	[last_traded_price] [decimal](19, 6) NULL,
	[change_percentage] [float] NOT NULL,
	[stand] [datetime2] NULL,
	[opening] [decimal](19, 6) NULL,
	[previous_closing] [decimal](19, 6) NULL,
	[traded_volume] [int] NOT NULL,
	[traded_amount] [decimal](19, 6) NULL,
	[daily_high] [decimal](19, 6) NULL,
	[daily_low] [decimal](19, 6) NULL,
	[high52w] [decimal](19, 6) NULL,
	[high52w_date] [varchar](255) NULL,
	[low52w] [decimal](19, 6) NULL,
	[low52w_date] [varchar](255) NULL,
	[security_type] [varchar](255) NULL,
	[wkn] [varchar](255) NULL,
	[currency] [varchar](255) NULL,
	[initial_listing_date] [varchar](255) NULL,
	[founding_year] [varchar](255) NULL,
	[fiscal_date] [varchar](255) NULL,
	[industry] [varchar](255) NULL,
	[market_capital] [bigint] NOT NULL,
	[pieces] [int] NOT NULL,
	[equity_capital] [bigint] NOT NULL,
	[number_of_employees] [int] NOT NULL,
	[last_general_meeting] [varchar](255) NULL,
	[portrait] [text] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
SET ANSI_PADDING ON
ALTER TABLE [dbo].[stock] ADD PRIMARY KEY CLUSTERED
(
	[isin_code] ASC
)


