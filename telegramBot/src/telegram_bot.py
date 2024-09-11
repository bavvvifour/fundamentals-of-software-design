import logging
from telegram import Update
from telegram.ext import ApplicationBuilder, ContextTypes, CommandHandler
from dotenv import load_dotenv
import os
import bitcoin_service

load_dotenv()

tg_token = os.getenv('TG_TOKEN')


logging.basicConfig(
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
    level=logging.INFO
)


async def start_command(update: Update, context: ContextTypes.DEFAULT_TYPE):
    await update.message.reply_text("Hi! Use /bitcoin to get the latest Bitcoin price.")


async def help_command(update: Update, context: ContextTypes.DEFAULT_TYPE):
    commands_text = (
        "/start - Start the bot\n"
        "/bitcoin - Get the latest Bitcoin price\n"
        "/help - Show this help message"
    )
    await update.message.reply_text(commands_text)


async def bitcoin_command(update: Update, context: ContextTypes.DEFAULT_TYPE):
    bitcoin_data = bitcoin_service.get_bitcoin_data()
    if bitcoin_data:
        updated_time = bitcoin_data['time']['updated']
        usd_rate = bitcoin_data['bpi']['USD']['rate']
        await update.message.reply_text(f"Bitcoin price as of {updated_time}:\nUSD: ${usd_rate}")
    else:
        await update.message.reply_text("Failed to retrieve Bitcoin data.")

if __name__ == '__main__':
    application = ApplicationBuilder().token(tg_token).build()

    application.add_handler(CommandHandler("start", start_command))
    application.add_handler(CommandHandler("help", help_command))
    application.add_handler(CommandHandler("bitcoin", bitcoin_command))

    application.run_polling()