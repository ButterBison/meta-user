SUMMARY = "Recipe for building an external wilc Linux kernel module"
SECTION = "PETALINUX/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit module

SRC_URI = "git://github.com/linux4sam/linux-at91.git;protocol=git;branch=${BRANCH};subpath=drivers/net/wireless/microchip/wilc1000 \
           file://0001-ultra96-modifications-16.1.patch \
		"
SRC_URI[sha256sum] = "d363601b353d0a22ad3354e77c6fc86d7e6d994ca872f71725c52fe07fb799d3"

SRCREV = "e9937336c36dbbee659b26ea05db52e03f7cd61b"

BRANCH = "linux-6.1-mchp"

DEPENDS += "virtual/kernel"

S = "${WORKDIR}/wilc1000"

EXTRA_OEMAKE = 'CONFIG_WILC=y \
		WLAN_VENDOR_MCHP=y \
		CONFIG_WILC_SDIO=m \
		CONFIG_WILC_SPI=n \
		CONFIG_WILC1000_HW_OOB_INTR=n \
		KERNEL_SRC="${STAGING_KERNEL_DIR}" \
		O=${STAGING_KERNEL_BUILDDIR}'