# SPDX-FileCopyrightText: Huawei Inc.
#
# SPDX-License-Identifier: Apache-2.0

# Common settings for all AllScenariOS images

inherit ohos-image

IMAGE_INSTALL_append = "\
			packagegroup-net-essentials \
			packagegroup-net-tools \
			packagegroup-ble-essentials \
			gdbserver \
			"

IMAGE_INSTALL_append = " ${@bb.utils.contains('MACHINE_FEATURES', 'optee', 'optee-client', '', d)} "