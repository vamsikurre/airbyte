# coding: utf-8

from __future__ import annotations
from datetime import date, datetime  # noqa: F401

import re  # noqa: F401
from typing import Any, Dict, List, Optional  # noqa: F401

from pydantic import AnyUrl, BaseModel, EmailStr, validator  # noqa: F401
from connector_builder.generated.models.stream_read_pages import StreamReadPages
from connector_builder.generated.models.stream_read_slice_descriptor import StreamReadSliceDescriptor


class StreamReadSlices(BaseModel):
    """NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).

    Do not edit the class manually.

    StreamReadSlices - a model defined in OpenAPI

        pages: The pages of this StreamReadSlices.
        slice_descriptor: The slice_descriptor of this StreamReadSlices [Optional].
        state: The state of this StreamReadSlices [Optional].
    """

    pages: List[StreamReadPages]
    slice_descriptor: Optional[StreamReadSliceDescriptor] = None
    state: Optional[Dict[str, Any]] = None

StreamReadSlices.update_forward_refs()
