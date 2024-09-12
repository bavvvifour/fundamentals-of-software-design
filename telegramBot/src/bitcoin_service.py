import requests
from requests.exceptions import HTTPError


def get_bitcoin_data():
    try:
        response = requests.get('http://first-api-service:8080/api/bitcoin')
        response.raise_for_status()

        return response.json()

    except HTTPError as http_err:
        print(f'HTTP error occurred: {http_err}')
    except Exception as err:
        print(f'Other error occurred: {err}')