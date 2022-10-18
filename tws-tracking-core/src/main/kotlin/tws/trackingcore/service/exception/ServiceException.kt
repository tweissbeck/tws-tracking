package tws.trackingcore.service.exception

import tws.tracking.lib.model.ErrorDto

class ServiceException(val errorDto: ErrorDto) : Exception()